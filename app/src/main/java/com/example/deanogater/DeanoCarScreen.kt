package com.example.deanogater

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import androidx.core.graphics.drawable.IconCompat

class DeanoCarScreen (carContext: CarContext) : Screen(carContext){

    val MAIN_URL = "http://nightingales.clanweb.eu"

    override fun onGetTemplate(): Template {
    val itemList = ItemList.Builder()


    val garageIcon0 = CarIcon.Builder(IconCompat.createWithResource(carContext,R.drawable.gar0)).build()
    val garageIcon1 = CarIcon.Builder(IconCompat.createWithResource(carContext,R.drawable.gar1)).build()
    val gateIcon0 = CarIcon.Builder(IconCompat.createWithResource(carContext, R.drawable.gat0)).build()

    val garage = GridItem.Builder()
        .setTitle("Garáž")
        .setImage(garageIcon0)
        .setOnClickListener { garageClick() }
        .build()

    val gate = GridItem.Builder()
            .setTitle("Brána")
            .setImage(gateIcon0)
            .setOnClickListener { gateClick() }
            .build()

    itemList.addItem(gate)
    itemList.addItem(garage)

        return GridTemplate.Builder().setSingleList(itemList.build()).setHeaderAction(Action.BACK).build()
    }


    fun garageClick(){
        zmenStav(1,"222",carContext,MAIN_URL)
    }

    fun gateClick(){
        zmenStav(2,"420420",carContext,MAIN_URL)
    }

    fun imageSwap(){

    }





}


