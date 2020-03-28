import { Component, OnInit, Input } from '@angular/core';
import { Actuality } from 'src/app/models/actuality';
import { Router } from '@angular/router';
import { ActualityService } from '../actuality.service';
import { GlobalConfig } from 'src/app/models/global-config';
@Component({
  selector: 'app-actualities-slider',
  templateUrl: './actualities-slider.component.html',
  styleUrls: ['./actualities-slider.component.css']
})
export class ActualitiesSliderComponent implements OnInit {

  @Input() width : string
  @Input() height : string

  actualities : Actuality[] = []

  endPoint : string = GlobalConfig.serverUrl

  onSlideClicked(value: any){
    this._router.navigate(['/actualities/actuality', value.activeId])
  }

  constructor(
    private _router: Router,
    private _actualityService : ActualityService
  ) { }

  ngOnInit(): void {
    this._actualityService.getActualitiesBetween(0, 3).subscribe((response) => {
      this.actualities = response
    })
  }

}
