package com.example.propertymanagementmobileapp.app

class Endpoints {

    companion object{

        private const val URL_USERS = "users"
//        private const val URL_SUB_CATEGORY = "subcategory/"
//        private const val URL_PRODUCT_BY_SUB_ID = "products/"

        fun getUsers(): String{
            return Config.BASE_URL + URL_USERS
        }

//        fun getSubCategoryByCatId(catId: Int):String{
//            return "${Config.BASE_URL + URL_SUB_CATEGORY + catId}"
//        }
//
//        fun getProductBySubId(subId: Int): String{
//            return "${Config.BASE_URL + URL_PRODUCT_BY_SUB_ID + subId}"
//        }
    }
}