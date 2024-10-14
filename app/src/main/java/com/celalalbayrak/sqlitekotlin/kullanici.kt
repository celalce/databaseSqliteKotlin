package com.celalalbayrak.sqlitekotlin

class kullanici {
    var id : Int = 0
    var adsoyad : String = ""
    var yasi: Int = 0
    // MainActivitiy de bu değişkenleri çağırabilmemiz için constructor oluşturmamız gerikir
    // yukardaki değişkenleri tanıtmak lazımdır.
    constructor( adsoyad: String, yasi: Int) {
        this.adsoyad = adsoyad
        this.yasi = yasi
    }
    constructor(){

    }

}