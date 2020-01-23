import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameSchedulesComponent } from './game-schedules.component';

describe('GameSchedulesComponent', () => {
  let component: GameSchedulesComponent;
  let fixture: ComponentFixture<GameSchedulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameSchedulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameSchedulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
