package Groovy

/**
 * Created by kachesiji on 2016/5/17.
 */
class GroovyHello {
    static def var="hello "+
            "world"+
            ",groovy!"
    static void asd() {
        def a = 'ada'
        def map = ['name': 'john', 'age': 14, 'sex': 'boy']
        map.each { entity ->
            println """${entity.key} = ${entity.value}"""
        }
        println (map instanceof String )
        println a.class
    }
    static void main(def args) {
//        def a = 1234
        def map = ['name': 'john', 'age': 14, 'sex': 'boy']
        map.father='Keller'
        java.lang.Object
//        map.each { entity ->
//            println """${entity.key} = ${entity.value}"""
//        }
//        map.each({key,value->    //key,value两个参数用于接受每个元素的键/值
//            println "$key:$value"})
//        map.each{println it}     //it是一个关键字，代表map集合的每个元素
//        map.each({ println it.getKey()+"-->"+it.getValue()})
//        println (map instanceof String )
//        println a.class
//        repeat(var,5)
//        def collect=["a","b","c"]
//        for(i in 0..<collect.size()){
//            print collect.get(i)+" "
//            print collect[i]+" : ${i} "
//        }
//        println null
//        for(i in 0..collect.size()){
//            print collect.get(i)+" "
//            print collect[i]+" "
//            print collect[-i]+" : ${i} "
//        }
        def say={word->
            println "Hi,$word!"
        }
        say('dsjsldjlsdj')
//        println 'dsjsldjlsdj'.class
        saya('ass','bss')
    }
   static  def saya(def a,def b){
    println "$a + $b"
    };



//    static def repeat(val,repeat=3){
//        for(i in 0..<repeat){
////            println val
//            println "This is ${i}:${val}"
//        }
//    }

}
