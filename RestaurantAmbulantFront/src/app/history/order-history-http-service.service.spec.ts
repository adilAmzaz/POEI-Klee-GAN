import { TestBed } from '@angular/core/testing';

import { OrderHistoryHttpServiceService } from './order-history-http-service.service';

describe('OrderHistoryHttpServiceService', () => {
  let service: OrderHistoryHttpServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderHistoryHttpServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
