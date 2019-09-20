import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ENdComponent } from './end.component';

describe('ENdComponent', () => {
  let component: ENdComponent;
  let fixture: ComponentFixture<ENdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ENdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ENdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
