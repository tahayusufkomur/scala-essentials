package lectures.part2

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE
    
    // add fields/methods
    def openDoc(): Unit =
      if(this == READ) println("Opening the document...")
      else println("reading is permitted!")
  }
  
  val somePermissions: Permissions = Permissions.READ
  
  // constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }
  
  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = {
      if(bits == 4) PermissionsWithBits.READ
      else if(bits == 2) PermissionsWithBits.WRITE
      else if(bits == 1) PermissionsWithBits.EXECUTE
      else PermissionsWithBits.NONE
    }
  }
  
  val bittedPermission: PermissionsWithBits = PermissionsWithBits.fromBits(4)
  val allPermissions = PermissionsWithBits.values
  
  def main(args: Array[String]): Unit = {
    somePermissions.openDoc()
    println(bittedPermission)
    println(bittedPermission.ordinal)
    println(s"Values = ${PermissionsWithBits.values}")
  }
  
}


