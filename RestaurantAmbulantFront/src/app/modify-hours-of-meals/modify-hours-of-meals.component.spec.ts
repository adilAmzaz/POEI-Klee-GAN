import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyHoursOfMealsComponent } from './modify-hours-of-meals.component';

describe('ModifyHoursOfMealsComponent', () => {
  let component: ModifyHoursOfMealsComponent;
  let fixture: ComponentFixture<ModifyHoursOfMealsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyHoursOfMealsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyHoursOfMealsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
