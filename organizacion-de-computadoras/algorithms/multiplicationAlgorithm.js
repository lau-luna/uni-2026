/*
    This function applies the Restoring Division Algorithm (Q / S) and prints via console the table with all of the steps.

    m: Multiplicand. (Multiplicando).
    M: Multiplier. (Multiplicador).
    A: Auxiliary register. (Registro auxiliar).

    Example table composition with 4 bit registers:

    m m m m |
    A A A A | M M M M
    --------+--------
    
    Previous to the algorithm.
    We complement the Divisor (S) inside the method because we are going to do several subtractions.
    And subtraction on the ALU is simply doing R + complement of Q.

    Multiplication Algorithm (ALU)
      (1) Check the least significant bit of M,
          if it's 1: (+) ->(>>) with 
          if it's 0: (>>)

      Repeat as many times as the register size.


    Operations:
    (>>) Shift right.
    (+) Add.
    
    @pre Q must be a String representing a binary number.
    @pre S must be a String representing a binary number.
*/

function restorationDivisionAlgorithm(Q, S) {
    // Create arrays containing each digit as unique elements.
    var Qarr = String(Q).split('').map(Number);
    var SarrOrg = String(S).split('').map(Number);
      
    // Print the division as arithmetic expression.
    console.log(Qarr.join('') + " / " + SarrOrg.join('') + "\n");
    
    // Complement S.
    var Sarr = complement(SarrOrg);

    let registerSize = Qarr.length;
   
    // End method if the register sizes does not match.
    if (Qarr.length != Sarr.length) {
        console.log("The registers have different sizes!");
        return;
    }

    // Initialize the Aux register R with all zeros.
    let Rarr = Qarr.map(() => 0);
    
    // Dynamic separation bar.
    var divisionBar = Qarr.map(() => "----").join('') + "-";
    divisionBar = divisionBar.slice(0, divisionBar.length/2) + 
                  "+" + divisionBar.slice((divisionBar.length/2)+1);
    
    // Print the top of the table.
    console.log(Rarr.join(' ') + " | " + Qarr.join(' '));
    console.log(Sarr.join(' ') + " | ");
    console.log(divisionBar);
    
    // Restoring Division Algorithm
    for (let i = 0; i < registerSize; i++) {
        
        // Shift (Aux ++ Q)
        Rarr = [...Rarr.slice(1), Qarr[0]]; // (<<) R with Q_n.
        Qarr = [...Qarr.slice(1), 0];   // (<<) Q with 0.
        let prevRarr = Rarr; // Store the previous value of R.
        console.log(Rarr.join(' ') + " | " + Qarr.join(' ') + "  <<");
        
        // Subtract (Add complement of S to Aux)
        Rarr = binarySum(Rarr, Sarr);
        console.log(Rarr.join(' ') + " | " + Qarr.map(() => "  ").join('') + " -");
        
        
        /* Restore or not*/
        if (Rarr[0] == 1) {
            Rarr = prevRarr;  // Restore R to the previous value.
            Qarr = [...Qarr.slice(0, registerSize-1), 0]; // Q_0 := 0.
            console.log(Rarr.join(' ') + " | " + Qarr.join(' ') + "  Res");  
        } else {
            Qarr = [...Qarr.slice(0, registerSize-1), 1];  // Q_0 := 1
            console.log(Rarr.join(' ') + " | " + Qarr.join(' '));
        }
        
        // Print the separation bar
        console.log(divisionBar);
    }
    
    // Print Quotient and Rest.
    let cociente = Qarr.join(' ');
    let resto = Rarr.join(' ');
    console.log("\nResto:    " + resto + " = " + toDecimal(Rarr));
    console.log("Cociente: " + cociente + " = " + toDecimal(Qarr));

    
}

/**
 * Given a binary integer array, remove all the zeros to the left, avoiding JavaScript to interpret them as octal.
 */
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
 * Takes two arrays representation binary numbers and returns 
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

/**
 * Given a binary number represented in an array, return the array with the complement of that number. 
 */
function complement(a) {
    let aCopy = [...a];
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
    aCopy.splice(a.length - arr.length);
    arr = [...aCopy.map((bit) => bit == 0 ? 1 : 0), ...arr];
    
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
