import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ToprentcategoriesComponent } from './toprentcategories.component';

describe('ToprentcategoriesComponent', () => {
  let component: ToprentcategoriesComponent;
  let fixture: ComponentFixture<ToprentcategoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ToprentcategoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ToprentcategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
