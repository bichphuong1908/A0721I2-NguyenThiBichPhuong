import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomeCreateComponent } from './custome-create.component';

describe('CustomeCreateComponent', () => {
  let component: CustomeCreateComponent;
  let fixture: ComponentFixture<CustomeCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomeCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
