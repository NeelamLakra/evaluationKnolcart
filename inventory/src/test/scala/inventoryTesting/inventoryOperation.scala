package inventoryTesting
import org.scalatest.FunSuite
import inventoryServices._


class inventoryOperation extends FunSuite {
  val itemList:Map[Int,Items]=Map()
  val cart = new InventoryOperations
  val newProduct = Items("shirt","clothing","amazon",2200)
  val itemListExisted:Map[Int,Items]=Map(2->Items("headphones","accessories","flipkart",3456))
  test("testing add product method with valid key"){
    assert(cart.addProduct(itemList,newProduct,1) === Map(1-> Items("shirt","clothing","amazon",2200)))
  }

  test("testing delete method with existing id"){
    assert(cart.deleteProduct(itemListExisted,2)===Map())
  }
}
