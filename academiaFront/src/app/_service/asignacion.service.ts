import { HttpClient } from '@angular/common/http';
import { Asignacion } from './../_model/asignacion';
import { CRUDService } from './crud.service';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AsignacionService extends CRUDService<Asignacion>{

  constructor(protected override _http: HttpClient) {
    super(
      _http,
      `${environment.HOST}/asignaciones`
    )
  }

  listarestudiantesPorMaestro(id: number) {
    let url = `${environment.HOST}/asignaciones/buscar/${id}`;
    return this._http.get<Asignacion[]>(`${url}`);
  }
}
