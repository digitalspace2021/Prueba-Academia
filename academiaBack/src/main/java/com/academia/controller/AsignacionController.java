package com.academia.controller;

import com.academia.entity.AsignacionEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController extends CRUDControllerImpl<AsignacionEntity, Integer>{

}
