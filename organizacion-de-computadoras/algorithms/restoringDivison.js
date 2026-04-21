/*
    Q: Dividend.
    S: Divisor.
    R: aux register.
*/

function restorationDivisionAlgorithm(Q, S) {
    var Qarr = String(Q).split('').map(Number);
    var SarrOrg = String(S).split('').map(Number);
    
    console.log(Qarr.join('') + " / " + SarrOrg.join('') + "\n");
    
    var Sarr = complement(SarrOrg);
    let registerSize = Qarr.length;
    
    if (Qarr.length != Sarr.length) {
        console.log("The registers have different sizes!");
        return;
    }

        
    let Rarr = Qarr.map(() => 0);
    var divisionBar = Qarr.map(() => "----").join('') + "-";
    divisionBar = divisionBar.slice(0, divisionBar.length/2) + 
                  "+" + divisionBar.slice((divisionBar.length/2)+1);
    
    console.log(Rarr.join(' ') + " | " + Qarr.join(' '));
    console.log(Sarr.join(' ') + " | ");
    console.log(divisionBar);
    
    for (let i = 0; i < registerSize; i++) {
        
        // Shift (Aux ++ Q)
        Rarr = [...Rarr.slice(1), Qarr[0]];
        Qarr = [...Qarr.slice(1), 0];
        let prevRarr = Rarr;
        console.log(Rarr.join(' ') + " | " + Qarr.join(' ') + "  <<");
        
        // Substract (Add complement of S to Aux)
        Rarr = binarySum(Rarr, Sarr);
        console.log(Rarr.join(' ') + " | " + Qarr.map(() => "  ").join('') + " -");
        
        
        /* Restore 
            If the most significative bit of Aux is 1:
             - Change the least significative bit of Q to 0 & restore the
                auxiliar register to its previous value.
            If is 0
             - Change the least significative bit of Q to 0
        */
        if (Rarr[0] == 1) {
            Rarr = prevRarr;
            Qarr = [...Qarr.slice(0, registerSize-1), 0];
            console.log(Rarr.join(' ') + " | " + Qarr.join(' ') + "  Res");
        } else {
            Qarr = [...Qarr.slice(0, registerSize-1), 1];
            console.log(Rarr.join(' ') + " | " + Qarr.join(' '));
        }
        
        console.log(divisionBar)
        
    }

    let cociente = Qarr.join(' ');
    let resto = Rarr.join(' ');
    console.log("\nResto:    " + resto + " = " + toDecimal(Rarr));
    console.log("Cociente: " + cociente + " = " + toDecimal(Qarr));

    
}

function cleanLeftZeros(a) {
  let found = false;
  let firstZeroAt = -1;
  for (let i = 0; i < a.length && !found; i++) {
    if (a[i] == 1) {
      found = true;
      firstZeroAt = i;
    }
  }
  return a.slice(firstZeroAt);
}


/**
 * Takes two arrays represention binary numbers and returns 
 * their addition in an array.
 * It truncates the number to stay on the register size.
 */
function binarySum(a, b) {
    let carry = 0;
    let sum = [];
    
    for (let i = a.length - 1; i >= 0; i--) {
        let bitSum = a[i] + b[i] + carry;
        
        if (bitSum === 0) {
            sum[i] = 0;
            carry = 0;
        } else if (bitSum === 1) {
            sum[i] = 1;
            carry = 0;
        } else if (bitSum === 2) {  // 1 + 1
            sum[i] = 0;
            carry = 1;
        } else if (bitSum === 3) {  // 1 + 1 + carry
            sum[i] = 1;
            carry = 1;
        }
    }
    
    return sum;
}

function complement(a) {
    let arr = [];
    let found = false;
    for (let i = a.length-1; i >= 0 && !found ; i--) {
        if (a[i] == 1) { 
            found = true;
        } else {
            arr.push(a[i]);
        }
    }
    arr = [1, ...arr];
    a.splice(a.length - arr.length);
    arr = [...a.map((bit) => bit == 0 ? 1 : 0), ...arr];
    
    return arr;
}

/**
 * Takes a binary number and returns it in decimal representation.
 * Representation on radix 2 theorem.
 */
function toDecimal(a) {
  a = cleanLeftZeros(a);
  var arr = a;

  for (var i = arr.length-1, j = 0; i >= 0; i--, j++) {
    arr[i] = arr[i] * Math.pow(2, j);
  }
  
  arr = arr.reduce((a, b) => a + b)
  return arr;
}


/**
 * Takes a decimal number and returns it in binary representation.
 * Division algorithm.
 * a = b*q + r
 */
function toBinary(a) {
  var r = 0, s = 0;

  // TODO: implement.

  return undefined;
}


restorationDivisionAlgorithm("0101", "0010");
