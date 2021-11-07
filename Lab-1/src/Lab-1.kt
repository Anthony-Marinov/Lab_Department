abstract class Employee (
    var firstname: String,
    var secondname: String,
    var exp: Int,
    var base_sal : Double
){
    open fun giveSalary(): Double {
        if (exp > 2 && exp < 5 ) return base_sal + 200.0
        if (exp > 5) return base_sal * 1.2 + 500.0
        return base_sal
    }
}

class Manager(
    firstname: String,
    secondname: String,
    exp: Int,
    base_sal: Double,
    var Team: MutableList<Employee> = mutableListOf()
): Employee(firstname,secondname, exp, base_sal) {
    override fun giveSalary(): Double {
        var Dev_Count = Team.filterIsInstance<Developer>().count()
        var Des_Count = Team.filterIsInstance<Designer>().count()
        var TeamCount =  Des_Count + Dev_Count
        if (TeamCount > 5 && TeamCount < 10)  return super.giveSalary() + 200.0
        if (TeamCount > 10) return super.giveSalary() + 300.0
        if (Dev_Count > TeamCount/2) return super.giveSalary() * 1.1
        return super.giveSalary()
    }
}

class Designer (
    firstname: String,
    secondname: String,
    exp: Int,
    base_sal : Double,
    var coef: Double
) : Employee(firstname,secondname, exp, base_sal){
    override fun giveSalary() : Double{
        return super.giveSalary() * coef
    }
}

class Developer (
    firstname: String,
    secondname: String,
    exp: Int,
    base_sal: Double
) : Employee(firstname,secondname,exp,base_sal)

class Department(
    var managers: MutableList<Manager> = mutableListOf()
){
    fun giveSallaryAll(){
        managers.forEach{manager -> manager.giveSalary()
        manager.Team.forEach{employee -> employee.giveSalary()}}
    }
}

fun main() {
    //------------------- Team №2 -----------------------//
    val des1 = Designer("Mykita", "Holub", 3, 135.0, 0.7)
    val dev1 = Developer("Ivan", "Ivanica", 2, 20.0)
    val dev2 = Developer("Anton", "Koshev", 35,40.0)
    val dev3 = Developer("Anna", "Stela", 20, 30.0)
    val manager1 = Manager("Chris", "Wakin", 3, 320.0)
    manager1.Team.add(des1)
    manager1.Team.add(dev1)
    manager1.Team.add(dev2)
    manager1.Team.add(dev3)

    //------------------- Team №1 -----------------------//
    val des2 = Designer("Lester", "Washington", 3, 135.0, 0.45)
    val des3 = Designer("Kun", "Zoo", 3, 135.0, 0.6)
    val dev4 = Developer("Steve", "Voshun", 5, 25.0)
    val dev5 = Developer("Albert","Noshi", 4,22.5)
    val dev6 = Developer("Stephen","Riastov", 45, 55.0)
    val manager2 = Manager("Rahim", "As Numi", 5, 400.0)
    manager2.Team.add(des2)
    manager2.Team.add(des3)
    manager2.Team.add(dev4)
    manager2.Team.add(dev5)
    manager2.Team.add(dev6)

    //----------------- giveSallary -------------------------//
    val department = Department()
    department.giveSallaryAll()
    println(dev1.firstname + " " + dev1.secondname + " got salary: " + dev1.giveSalary())
    println(dev2.firstname + " " + dev2.secondname + " got salary: " + dev2.giveSalary())
    println(dev3.firstname + " " + dev3.secondname + " got salary: " + dev3.giveSalary())
    println(dev4.firstname + " " + dev4.secondname + " got salary: " + dev4.giveSalary())
    println(dev5.firstname + " " + dev5.secondname + " got salary: " + dev5.giveSalary())
    println(dev6.firstname + " " + dev6.secondname + " got salary: " + dev6.giveSalary())
    println(des1.firstname + " " + des1.secondname + " got salary: " + des1.giveSalary())
    println(des2.firstname + " " + des2.secondname + " got salary: " + des2.giveSalary())
    println(des3.firstname + " " + des3.secondname + " got salary: " + des3.giveSalary())
    println(manager1.firstname + " " + manager1.secondname + " got salary: " + manager1.giveSalary())
    println(manager2.firstname + " " + manager2.secondname + " got salary: " + manager2.giveSalary())
}
