
import { Estudiante } from './../_model/estudiante';
import { CRUDService } from './crud.service';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService extends CRUDService<Estudiante>{

  constructor(protected override _http: HttpClient) {
    super(
      _http,
      `${environment.HOST}/estudiantes`
    )
  }

  listarestudiantesPorMaestro(id: number) {
    let url = `${environment.HOST}/estudiantes/buscar/${id}`;
    return this._http.get<Estudiante[]>(`${url}`);
  }
}
