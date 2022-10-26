package com.academia.controller;

import com.academia.entity.MaestroEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maestros")
public class MaestroController extends CRUDControllerImpl<MaestroEntity, Integer>{
}
