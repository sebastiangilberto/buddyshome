/**
 * Copyright (C) 2012 the original author or authors.
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

package conf;


import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  
    	
    	router.GET().route("/table").with(ApplicationController.class, "table");
    	
        router.GET().route("/").with(ApplicationController.class, "index");   

        router.GET().route("/login").with(ApplicationController.class, "login");
        
        router.GET().route("/singup").with(ApplicationController.class, "singup");  
        
        router.POST().route("/singupOk").with(ApplicationController.class, "singupOk");
        
        router.GET().route("/help").with(ApplicationController.class, "help");
        
        router.GET().route("/host").with(ApplicationController.class, "host");
        
        router.POST().route("/hostOk").with(ApplicationController.class, "hostOk");
        
        router.GET().route("/guest").with(ApplicationController.class, "guest");
        
        router.GET().route("/contacto").with(ApplicationController.class, "contacto");
        
        router.POST().route("/procesarContacto").with(ApplicationController.class, "procesarContacto");
        
        router.GET().route("/experiencias").with(ApplicationController.class, "experiencias");
        
        router.POST().route("/procesarExperiencia").with(ApplicationController.class, "procesarExperiencia");
                
        
        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
