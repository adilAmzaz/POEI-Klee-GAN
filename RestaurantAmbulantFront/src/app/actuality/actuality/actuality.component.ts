import { Component, OnInit } from '@angular/core';
import { ActualityService } from '../actuality.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Actuality } from 'src/app/models/actuality';
import { GlobalConfig } from 'src/app/models/global-config';

@Component({
  selector: 'app-actuality',
  templateUrl: './actuality.component.html',
  styleUrls: ['./actuality.component.css']
})
export class ActualityComponent implements OnInit {

  actualityId: number = 0
  actuality: Actuality = new Actuality()
  actualitiesIds: number[] = []

  endPoint : string = GlobalConfig.serverUrl

  nextActuality() {
    this._router.navigate(['actualities/actuality', this.actualitiesIds[this.actualitiesIds.indexOf(this.actualityId)+1]])
    window.scrollTo(0,0)
  }

  previousActuality() {
    this._router.navigate(['actualities/actuality', this.actualitiesIds[this.actualitiesIds.indexOf(this.actualityId)-1]])
    window.scrollTo(0,0)
  }

  constructor(
    private actRoute: ActivatedRoute,
    private _router: Router,
    private _actualityService : ActualityService
  ) { }

  ngOnInit(): void {
    this.actRoute.paramMap.subscribe(params => {
      this.actualityId = +params.get('id')
      this._actualityService.getById(this.actualityId).subscribe((response) => {
        this.actuality = response
      })
    })
    this._actualityService.getIds().subscribe(
      (response) => {
        this.actualitiesIds = response
      }
    )
  }

}
