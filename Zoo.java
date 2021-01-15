import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import java.util.HashMap;

@Path("animals") 

@Produces(MediaType.APPLICATION_JSON)

public class UsersResource {

	static HashMap<Integer, HashMap<String, String>> animals = new HashMap<>();
    
	static Integer index = 0;

	@GET
    
	public Response getAnimals(){
        
		return Response.ok(animals).build();
	}

	@POST
	public Response giveBirthToAnAnimal(@FormParam("jmeno") String name, @FormParam("vek") String age) {
		if(name != null && age != null ){
			HashMap<String,String> newAnimal = new HashMap<>();
			newAnimal.put("jmeno", name);
			newAnimal.put("vek", age);
			animals.put(index, newAnimal);
			index++;
			return Response.ok(animals).build();
		} else {
			return Response.ok("VLOZTE PARAMETR").build();
		}
	}

	@GET
	@Path("{index}")
	public Response getAnimal(@PathParam("index") Integer index) {
		if(index != null && animals.get(index) != null){
			return Response.ok(animals.get(index)).build();
		} else {
			return Response.ok("NEEXISTUJE").build();
		}
	}

	@DELETE
	@Path("{index}")
	public Response slaughterAnimal(@PathParam("index") Integer index) {
		if(index != null){
			animals.remove(index);
		}
		return Response.ok(animals).build();
	}

	@PUT
	@Path("{index}")
	public Response changeAge(@PathParam("index") Integer index,@FormParam("jmeno") String name ,@FormParam("vek") String age) {
		if(animals.get(index) != null && index != null && name != null && age != null){
			HashMap<String,String> newAnimal = new HashMap<>();
			newAnimal.put("jmeno", name);
			newAnimal.put("vek", age);
			animals.put(index, newAnimal);
		}
		return Response.ok(animals).build();
	}





}
