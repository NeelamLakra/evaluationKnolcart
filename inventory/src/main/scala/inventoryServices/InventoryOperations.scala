package inventoryServices

class InventoryOperations extends product {
  def addProduct(itemList:Map[Int,Items],newProduct:Items,id:Int):Map[Int,Items]={
    if(id <= 0)
      {itemList}
    else {
      def addItem(itemList: Map[Int, Items], itemCount: Int): Map[Int, Items] = {
        itemCount match {
          case 0 => itemList
          case 1 => addItem(itemList + (id -> newProduct), itemCount - 1)
        }
      }

      addItem(itemList, 1)
    }
  }

  def deleteProduct(itemList:Map[Int,Items],itemId:Int):Map[Int,Items] ={
    if(itemId <=0)
      {itemList}
    else {
      def removeItem(itemList: Map[Int, Items], itemCount: Int): Map[Int, Items] = {
        itemCount match {
          case 0 => itemList
          case 1 => removeItem(itemList - itemId, itemCount - 1)
        }
      }

      removeItem(itemList, 1)
    }
  }



}
