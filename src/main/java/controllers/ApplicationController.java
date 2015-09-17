/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.jpa.UnitOfWork;
import ninja.params.Param;
import ninja.params.Params;
import ninja.params.PathParam;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import controllers.ApplicationController.SimplePojo;
import models.Host;
import models.MensajeContacto;
import models.MensajeExperiencia;
import models.Usuario;


@Singleton
public class ApplicationController {
	
	@Inject 
	Provider<EntityManager> entityManagerProvider;

	
	public Result table() {

		return Results.html();

	}	
	
//HOME
		
	public Result index() {

		return Results.html();

	}
	
//AYUDA
		
	public Result help() {

		return Results.html();

	}		
	
//INICIO SESION
	
	public Result login() {

		return Results.html();

	}
	
	
//REGISTRACION
	
	public Result singup() {

		return Results.html();

	}
	
//REGISTRACION EXITOSA
	
	@Transactional
	public Result singupOk(

		@Param("nombre") String n,
		@Param("apellido") String a,
		@Param("usuario") String u,
		@Param("password") String p,
		@Param("email") String e) {
		
	
		Result resultado = Results.html();
	
		EntityManager entityManager = entityManagerProvider.get();
		
		Usuario user;
		
		user = new Usuario(n, a, u, p, e);
		
		entityManager.persist(user);
					
						
		resultado.render("nombre", n);
		resultado.render("apellido", a);
		resultado.render("usuario", u);
		return resultado;


	}
	
//ANFITRION
	
	public Result host() {

		return Results.html();

	}	
	
//COMPARTIR HOGAR EXITOSAMENTE

	@Transactional
	public Result hostOk(

		@Param("titulo") String t,
		@Param("pais") String pa,
		@Param("precio") Long pr,
		@Param("descripcion") String d,
		@Param("estado") String e,
		@Param("file") String f)
		{
		
	
		Result resultado = Results.html();
	
		EntityManager entityManager = entityManagerProvider.get();
		
		Host host;
		
		host = new Host(t, pa, pr, d, e, f);
		
		entityManager.persist(host);
					
						
		resultado.render("pais", pa);
		return resultado;


	}

//CONTACTO

	public Result contacto() {

		Result resultado = Results.html();
		return resultado;

	}
	
	@Transactional
	public Result procesarContacto(
			
			@Param("nombre") String n, 
			@Param("email") String e, 
			@Param("descripcion") String d) {
		

		Result resultado = Results.html();

		EntityManager entityManager = entityManagerProvider.get();
		
		MensajeContacto mensaje;
		
		mensaje = new MensajeContacto(n, e, d);
		
		entityManager.persist(mensaje);
					
					
		resultado.render("nombre", n);
		resultado.render("email", e);
		resultado.render("descripcion", d);
		return resultado;

	}

	
//EXPERIENCIA

	@UnitOfWork
	public Result experiencias() {

		Result resultado = Results.html();
		
		EntityManager entityManager = entityManagerProvider.get();
		
		Query q = entityManager.createQuery("SELECT x FROM MensajeExperiencia x ORDER BY x.id DESC");
	    List<MensajeExperiencia> listado = (List<MensajeExperiencia>) q.getResultList();
		
	    resultado.render("listado", listado);
	    
		return resultado;

	}
	
	@Transactional
	public Result procesarExperiencia(
			@Param("nombre") String n, 
			@Param("experiencia") String e) {

		Result resultado = Results.html();

		EntityManager entityManager = entityManagerProvider.get();
		
		MensajeExperiencia exp;
		
		exp = new MensajeExperiencia(n, e);
		
		entityManager.persist(exp);
			
			
		

		
		if(n.equals("")) {
			return Results.redirect("/experiencias");
		}
		
				
		
		resultado.render("nombre", n);
		resultado.render("experiencia", e);
		return resultado;

	}
	
	
//INVITADO
	
		public Result guest() {

			Result resultado = Results.html();
			
			EntityManager entityManager = entityManagerProvider.get();
			
			Query q = entityManager.createQuery("SELECT x FROM Host x ORDER BY x.id DESC");
		    List<Host> ofertas = (List<Host>) q.getResultList();	
		    
   			resultado.render("ofertas", ofertas);
	    	
			return resultado;
						

		}
	
	
	public Result helloWorldJson() {

		SimplePojo simplePojo = new SimplePojo();
		simplePojo.content = "Hello World! Hello Json!";

		return Results.json().render(simplePojo);

	}

	public static class SimplePojo {

		public String content;

	}
}
