import { EstudianteService } from './../../_service/estudiante.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gestionar-maestro',
  templateUrl: './gestionar-maestro.component.html',
  styleUrls: ['./gestionar-maestro.component.css']
})
export class GestionarMaestroComponent implements OnInit {

  constructor(private _estudianteService: EstudianteService) { }

  ngOnInit(): void {
  }

}
