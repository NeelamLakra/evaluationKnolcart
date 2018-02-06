package inventoryServices

trait product {

def addProduct(itemList:Map[Int,Items],newProduct:Items,id:Int):Map[Int,Items]

  def deleteProduct(itemList:Map[Int,Items],itemId:Int):Map[Int,Items]


}
