@Path("animal")

public class ZOO {

    public String[] animals;

    @GET

    public Response getanim(@DefaultValue("-2147483648") @FormParam("id") int pos){

        if (pos == -2147483648)

            return Response.ok(Arrays.toString(animals)).build();

        return Response.ok(animals[pos]).build();
    }
    @PUT

    public Response addanim(@FormParam("animal") String name, @FormParam("id") int pos){

        if (animals[pos] != null)

            return Response.status(400).build();

        animals[pos] = name;

        return Response.ok().build();

    }
    @DELETE

    public Response remanim(@FormParam("id") int pos){

        animals[pos] = null;


        return Response.ok().build();

    }
}