package Kotlin

class PetKt (var id: Int, var category: Map<String, Any>, var name: String, var status: String){



    override fun toString(): String {
        return "PetKt(id=$id, category=$category, name='$name', status='$status')"
    }
}