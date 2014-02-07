package day4

object categories {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
     
  case class Category(val id: Int, val name: String, val parentId : Int) {
  	def apply(_id: Int, _name: String, _parentId : Int): Category = new Category(_id,_name,_parentId)
  	override def toString = "Cat{" + name+ "}"
  }
 
  class CategoryTreeNode(val nodeValue: Category, val parentNode: CategoryTreeNode){
    var childNodes: List[CategoryTreeNode] = null
  	def isRoot = parentNode ==null
  	override def toString = "Node{value=" + nodeValue +  ( if(childNodes!=null && childNodes.size >0) ", childs=" + childNodes+ "}" else "" )
  }
  	
  def makeTree(categories: List[Category]): List[CategoryTreeNode] = {
  	val parentId =0
  	val rootCats = categories.filter(_.parentId == 0)
  	val remainingCats = categories.filter(_.parentId != 0)
  	for{rootCat <- rootCats}
  	    yield{ val node = new CategoryTreeNode(rootCat, null)
  	           node.childNodes = makeChildTree(node, remainingCats)
  	           node }
  }                                               //> makeTree: (categories: List[day4.categories.Category])List[day4.categories.
                                                  //| CategoryTreeNode]
  		
  def makeChildTree(parentCatNode: CategoryTreeNode, fromCategories: List[Category]): List[CategoryTreeNode] = {
  	val remainingCats = fromCategories.filter(_.parentId !=	parentCatNode.nodeValue.id)
  	val childCategories = fromCategories.filter(_.parentId ==	parentCatNode.nodeValue.id)
  	for {cat <- childCategories}
  	     yield{ val catNode = new CategoryTreeNode(cat, parentCatNode)
  							catNode.childNodes = makeChildTree(catNode, remainingCats)
  							catNode }
  }                                               //> makeChildTree: (parentCatNode: day4.categories.CategoryTreeNode, fromCatego
                                                  //| ries: List[day4.categories.Category])List[day4.categories.CategoryTreeNode]
                                                  //| 
  		
  		
  val categories = List( Category(1, "FootWear", 0),
  Category(11, "Shoes", 1),
  Category(111, "Leather Shoes", 11),
  Category(112, "Sports Shoes", 11),
  Category(113, "Canvas Shoes", 11),
  Category(12, "sandel", 1),
  Category(13, "slippers", 1),
  Category(2, "Electronics", 0),
  Category(21, "Computers", 1),
  Category(211, "Laptops", 21),
  Category(212, "Destops", 21) )                  //> categories  : List[day4.categories.Category] = List(Cat{FootWear}, Cat{Shoe
                                                  //| s}, Cat{Leather Shoes}, Cat{Sports Shoes}, Cat{Canvas Shoes}, Cat{sandel}, 
                                                  //| Cat{slippers}, Cat{Electronics}, Cat{Computers}, Cat{Laptops}, Cat{Destops}
                                                  //| )
 
  val catTrees = makeTree(categories)             //> catTrees  : List[day4.categories.CategoryTreeNode] = List(Node{value=Cat{Fo
                                                  //| otWear}, childs=List(Node{value=Cat{Shoes}, childs=List(Node{value=Cat{Leat
                                                  //| her Shoes}, Node{value=Cat{Sports Shoes}, Node{value=Cat{Canvas Shoes})}, N
                                                  //| ode{value=Cat{sandel}, Node{value=Cat{slippers}, Node{value=Cat{Computers},
                                                  //|  childs=List(Node{value=Cat{Laptops}, Node{value=Cat{Destops})})}, Node{val
                                                  //| ue=Cat{Electronics})
  
  //TODO -- factory method in categorytreenode to create itself
  // Tree - genralize to take any node value as T
  // logic to find child node for a node as function object, injectable
  // handle the categories and remaining categories list more properly
  // if the category is a root category
}