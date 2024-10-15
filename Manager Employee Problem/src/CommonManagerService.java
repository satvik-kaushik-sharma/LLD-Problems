import Employee.Employee;

public class CommonManagerService {

    public static Employee findLCAManager(Employee ceo, Employee first, Employee second) {
        Employee[] res = new Employee[1];
        res[0] = null;
        helper(ceo, first, second, res);
        return res[0];
    }

//    lcaManager has to be an array since we have to return count in helper
//    => need to set lcaManager from within recursive calls
//    we are using the array as a ref variable (like in c++)
    public static int helper(Employee manager, Employee first, Employee second, Employee[] lcaManager) {
        if(manager == null) return 0;
        int found = 0;
        if(manager == first || manager == second) {
            found++;
        }
        for(Employee managed: manager.getManaged()) {
            found += helper(managed, first, second, lcaManager);
        }

        if(found == 2 && lcaManager[0] == null) {
//            will be updated only once - deepest possible in the tree i.e. first time we find both Employees from a node
            lcaManager[0] = manager;
        }
        return found;
    }
}
