import { TestBed } from '@angular/core/testing';

import { GameSchedulesService } from './game-schedules.service';

describe('GameSchedulesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GameSchedulesService = TestBed.get(GameSchedulesService);
    expect(service).toBeTruthy();
  });
});
