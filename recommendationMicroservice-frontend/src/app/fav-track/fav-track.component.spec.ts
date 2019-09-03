import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavTrackComponent } from './fav-track.component';

describe('FavTrackComponent', () => {
  let component: FavTrackComponent;
  let fixture: ComponentFixture<FavTrackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FavTrackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavTrackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
