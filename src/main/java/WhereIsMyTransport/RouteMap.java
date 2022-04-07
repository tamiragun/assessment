package WhereIsMyTransport;

import java.util.*;

public class RouteMap {
    // Create a synchronised map of the routes and their names, so their order stays the same - this is easier for testing
    private Map<String, Route> routesAndNames = Collections.synchronizedMap(new LinkedHashMap<String, Route>());

    public RouteMap(String csvRoutes) {
        // Split the input routes
        String[] inputRouteList = csvRoutes.split(",");
        // Add each route info to the map
        for (int i = 0; i< inputRouteList.length; i++) {
            String[] routeElements = inputRouteList[i].split(";");
            String routeName = routeElements[1];
            String[] routeIdElements = routeElements[0].split(" ");
            String routeId = routeIdElements[0];
            this.routesAndNames.put(routeId, new Route(routeId, routeName));
        }
    }

    public Map<String, Route> getRoutesAndNames() {
        return this.routesAndNames;
    }

}
