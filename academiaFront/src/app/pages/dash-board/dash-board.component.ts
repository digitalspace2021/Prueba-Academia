import { AsignacionService } from './../../_service/asignacion.service';
import { Asignacion } from './../../_model/asignacion';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Maestro } from './../../_model/maestro';
import { Estudiante } from './../../_model/estudiante';
import { MaestroService } from './../../_service/maestro.service';
import { EstudianteService } from './../../_service/estudiante.service';
import { GestionarMaestroComponent } from './../gestionar-maestro/gestionar-maestro.component';
import { GestionarEstudianteComponent } from './../gestionar-estudiante/gestionar-estudiante.component';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { map } from 'rxjs';

@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {
  displayedColumns: string[] = [
    'estudiante'
  ];


  estudiantes: Estudiante[];
  maestros: Maestro[];
  estudiantesSelec: Estudiante[];

  formAsignacion: FormGroup;
  formMaestro: FormGroup;

  @ViewChild(MatSort) sort: MatSort;
  dataSource: MatTableDataSource<Estudiante>

  constructor(
    private _dialog: MatDialog,
    private _formBuilder: FormBuilder,
    private _estudianteService: EstudianteService,
    private _maestroService: MaestroService,
    private _asignacionService: AsignacionService
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.listarMaestros();
    this.listarEstudiantes();
    this.actualizarSelect();
  }

  initForm() {
    this.formAsignacion = this._formBuilder.group({
      maestro: [null, [Validators.required]],
      estudiante: [null, [Validators.required]],
    });

    this.formMaestro = this._formBuilder.group({
      maestroSelect: [null, [Validators.required]]
    });

  }

  abrirDialogEstudiante() {
    let dialogRef = this._dialog.open(GestionarEstudianteComponent, {
      width: '300px',
      data: "estudiante"
    });
    dialogRef.afterClosed().subscribe(res => {
      if (res == true) {
        this.actualizarSelect();
      }
    });
  }

  abrirDialogMaestro() {
    let dialogRef = this._dialog.open(GestionarEstudianteComponent, {
      width: '300px',
      data: "maestro"
    });
    dialogRef.afterClosed().subscribe(res => {
      if (res == true) {
        this.actualizarSelect();
      }
    });
  }

  listarMaestros() {
    this._maestroService.listar().subscribe(data => {
      this.maestros = data;
    });
  }

  listarEstudiantes() {
    this._estudianteService.listar().subscribe(data => {
      this.estudiantes = data;
    });
  }

  agregar() {
    let estudiante = new Estudiante();
    estudiante.id = this.estudiante.value;

    let maestro = new Maestro();
    maestro.id = this.maestro.value;

    let asignacion = new Asignacion();
    asignacion.estudiante = estudiante;
    asignacion.maestro = maestro;

    this._asignacionService.guardar(asignacion).subscribe(() => {
      this.actualizarSelect();
      this.formAsignacion.reset();
    });
  }

  buscar() {
    console.log(this.maestroSelect.value);

    let idMaestro = this.maestroSelect.value;
    this._estudianteService.listarestudiantesPorMaestro(idMaestro).subscribe(data => {
      this.formMaestro.reset();
      this.dataSource = new MatTableDataSource(data);
    });
  }

  actualizarSelect() {
    this._maestroService.listar().subscribe(data => { this.maestros = data });
    this._estudianteService.listar().subscribe(data => { this.estudiantes = data });
  }

  // ------------------------------ get formAsignacion ------------------------------
  get maestro() {
    return this.formAsignacion.get("maestro")!
  }

  get estudiante() {
    return this.formAsignacion.get("estudiante")!
  }

  // ------------------------------ get formAsignacion ------------------------------
  get maestroSelect() {
    return this.formMaestro.get("maestroSelect")!
  }
}
