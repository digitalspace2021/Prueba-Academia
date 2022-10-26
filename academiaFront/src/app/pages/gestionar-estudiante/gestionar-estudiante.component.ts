import { MaestroService } from './../../_service/maestro.service';
import { EstudianteService } from './../../_service/estudiante.service';
import { Maestro } from './../../_model/maestro';
import { Estudiante } from './../../_model/estudiante';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-gestionar-estudiante',
  templateUrl: './gestionar-estudiante.component.html',
  styleUrls: ['./gestionar-estudiante.component.css']
})
export class GestionarEstudianteComponent implements OnInit {

  formEstudiante: FormGroup;
  estudiante: Estudiante;

  constructor(
    private _estudianteService: EstudianteService,
    private _maestroService: MaestroService,
    private _formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: string,
    public _dialogRef: MatDialogRef<GestionarEstudianteComponent>,
  ) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.formEstudiante = this._formBuilder.group({
      id: [null],
      nombre: [null, [Validators.required]],
      apellido: [null, [Validators.required]],
    })
  }

  operar() {

    if (this.data === "estudiante") {
      let estudiante = new Estudiante();
      estudiante.nombre = this.nombre.value;
      estudiante.apellido = this.apellido.value;

      this._estudianteService.guardar(estudiante).subscribe(data =>{
        this._dialogRef.close(true);
      });
    }

    if (this.data === "maestro") {
      let maestro = new Maestro();
      maestro.nombre = this.nombre.value;
      maestro.apellido = this.apellido.value;

      this._maestroService.guardar(maestro).subscribe(data =>{
        this._dialogRef.close(true);
      });

    }

  }

  // ------------------------------ get formEstudiante ------------------------------
  get id() {
    return this.formEstudiante.get("id")!
  }

  get maestro() {
    return this.formEstudiante.get("maestro")!
  }

  get nombre() {
    return this.formEstudiante.get("nombre")!
  }

  get apellido() {
    return this.formEstudiante.get("apellido")!
  }

}
