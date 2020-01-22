{
   /**
    * reverseArray produces new Array
    * @param {Array} arg 
    */ 
   function reverseArray(arg){
        let currentArray = [];
        let lastIndex = arg.length-1;
        const reverse = function (){
            for(index in arg)
                currentArray.push(arg[lastIndex--])
            
            return currentArray;
        }
        return reverse.apply();
   }

   /**
    * reverseArrayInPlace rearranges element in the same memory location
    * @param {Array} arg 
    */
   function reverseArrayInPlace(arg){
     const reverse = function (){
         for(index in arg){
             //Swaps values until it reaches the middle of the array
             if(Math.round((arg.length)/2) == index) break;
             
             //Computes the last  value {swapIndex} and current value {index} to swap
             let swapIndex = (arg.length - 1) - index
             let temp = arg[index]
             arg[index] = arg[swapIndex]
             arg[swapIndex] = temp      
         }
         return arg
     }
     return reverse.apply()
   }

   /**
    * 
    * @param {Array} array 
    */
   function listToArray(array){
        let filteredArray = function processArray(){     
            let arrayValues = [];     
            array.forEach(function(value,index){
                if(index >= 1){
                    arrayValues.push(value)
                }
            })
            return arrayValues;
        }       

        return (function(){
            if(array.length == 1){
                return {
                    value : array[0],
                    rest: null
                }
            }else{
                return {
                    value : array[0],
                    rest: listToArray(filteredArray.apply())
                }
            }
        }())
   }

   function deepEqual(arg1,arg2){
        /** Test is valid object*/
        const validate = function(argKey1,argKey2){
            const test = function (){
                //checks for empty / null context
                if(this.length == 0){
                    return false;
                }     
                return (typeof this == "object")
            }
            return function(){
                
                if(test.apply(argKey1) && test.apply(argKey2)){
                    //Check keys first
                    if((argKey1.toString() === argKey2.toString())){
                        let flag = false;
                        //Check length of both arrays
                        if(argKey1.length == argKey2.length){
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                } 
            }
        }

       const predicate = function(){   
           const argKey1 = Object.keys(arg1 == null?'':arg1)
           const argKey2 = Object.keys(arg2 == null?'':arg2) 
           let flag = true;
           return function (){
              
              if(validate(argKey1,argKey2).apply()){
                
                for(key of argKey1){
                    arg1[key] === arg2[key] ? flag : flag = false;
                }

                return flag;
              }else{
                  return false;
              }       
           }
       }

       return predicate.apply()
   }




   const user = {
       'id': 1,
       'name':'Philip Sarfo',
       'age': 8,
       'color':'brown'
   }

   const user1 = {
        'id': 1,
        'name':'Philip Sarfo',
        'age': 8,
        'color':'brown'
   }


   console.log(listToArray([1,2,3]));
   console.log("Deep Equal",deepEqual(user,user1).apply());
   console.log("Reverse Array ["+reverseArray([1,2,3,4])+"]");
   console.log("Reverse In place "+reverseArrayInPlace([1,2,3,4]))

   /** Unit Testing */
   describe("W2d2JS Practice",function(){
       /** Reverse Array */
       it("reverseArray([1,2,3,4]) should return [4,3,2,1]",function(){
            assert.equal(reverseArray([1,2,3,4]).toString(),[4,3,2,1].toString())
       })

       /** Reverse Array Inplace */
       it("reverseArrayInPlace([1,2,3,4]) should return [4,3,2,1]",function(){
            assert.equal(reverseArrayInPlace([1,2,3,4]).toString(),[4,3,2,1].toString())
       })

       it("listToArray([1,2,3]) should return { value: 1, rest: { value: 2, rest: { value: 3, rest: null } } }",function(){
           assert.equal(listToArray([1,2,3]).toString(),"[object Object]")
       })

       it("deepEqual(user,user1) should return true",function(){
           assert.equal(deepEqual(user,user1).apply(),true)
       })
   })
}