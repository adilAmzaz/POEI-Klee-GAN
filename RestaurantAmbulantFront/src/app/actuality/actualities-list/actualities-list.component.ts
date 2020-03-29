import { Component, OnInit } from '@angular/core';
import { Actuality } from 'src/app/models/actuality';
import { ActualityService } from '../actuality.service';
import { GlobalConfig } from '../../models/global-config';

@Component({
  selector: 'app-actualities-list',
  templateUrl: './actualities-list.component.html',
  styleUrls: ['./actualities-list.component.css']
})
export class ActualitiesListComponent implements OnInit {

  actualities : Actuality[] = []
  actualitiesPerPage : number = 10
  page : number = 0
  pages : number = 0
  
  Arr = Array

  endPoint : string = GlobalConfig.serverUrl

  getPage() {
    this.scrollToTop()
    this._actualityService.getActualitiesBetween(this.page*this.actualitiesPerPage, (this.page+1)*this.actualitiesPerPage).subscribe(
      (response) => {
        this.actualities = response
      }
    )
  }

  newPage(newPage : number) {
    this.page = newPage
    this.getPage()
  }

  nextPage() {
    this.page ++
    this.getPage()
  }

  previousPage() {
    this.page --
    this.getPage()
  }

  scrollToTop() {
    (function smoothscroll() {
      let currentScroll = window.pageYOffset
      if (currentScroll > 0) {
        window.scrollTo(0, Math.max(0, currentScroll - 50))
        window.requestAnimationFrame(smoothscroll)
      }
    }) ()
  }

  constructor(
    private _actualityService : ActualityService
  ) { }

  ngOnInit(): void {
    this._actualityService.getCount().subscribe(
      (response) => {
        this.pages = Math.floor(response/this.actualitiesPerPage)
      }
    )
    this.getPage()
  }

}
