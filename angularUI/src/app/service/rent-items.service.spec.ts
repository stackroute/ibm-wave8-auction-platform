import { TestBed } from '@angular/core/testing';

import { RentItemsService } from './rent-items.service';

describe('RentItemsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RentItemsService = TestBed.get(RentItemsService);
    expect(service).toBeTruthy();
  });
});
