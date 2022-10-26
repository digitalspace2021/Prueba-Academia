import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionarMaestroComponent } from './gestionar-maestro.component';

describe('GestionarMaestroComponent', () => {
  let component: GestionarMaestroComponent;
  let fixture: ComponentFixture<GestionarMaestroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionarMaestroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionarMaestroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
