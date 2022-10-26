import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionarEstudianteComponent } from './gestionar-estudiante.component';

describe('GestionarEstudianteComponent', () => {
  let component: GestionarEstudianteComponent;
  let fixture: ComponentFixture<GestionarEstudianteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionarEstudianteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionarEstudianteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
