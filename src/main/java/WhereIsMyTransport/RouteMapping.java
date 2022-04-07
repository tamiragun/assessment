package WhereIsMyTransport;

import java.util.*;

public class RouteMapping {
    // Map of the routes and their names
    private Hashtable<String,String> routesAndNames = new Hashtable<>();

    public RouteMapping(String csvRoutes) {
        // Split the input routes
        String[] inputRouteList = csvRoutes.split(",");
        // Add each route info to the hashtable
        for (int i = 0; i< inputRouteList.length; i++) {
            String[] routeElements = inputRouteList[i].split(";");
            String routeName = routeElements[1];
            String[] routeIdElements = routeElements[0].split(" ");
            String RouteId = routeIdElements[0];
            this.routesAndNames.put(RouteId, routeName);
        }
    }

    public Hashtable<String, String> getRoutesAndNames() {
        return this.routesAndNames;
    }

}
