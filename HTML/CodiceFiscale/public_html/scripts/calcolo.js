/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let vocals = '';
let cons = '';
const vocali = ["A", "E", "I", "O", "U"];
let comuni = [
    "A271 Ancona", "A326 Aosta",
"A345 L'Aquila", "A662 Bari",
"A944 Bologna	", "B354 Cagliari",
"B519 Campobasso", "C352 Catanzaro",
"D612 Firenze",	"D969 Genova",
"F205 Milano",	"F839 Napoli",
"G273 Palermo",	"G478 Perugia",
"G942 Potenza",	"H501 Roma",
"L219 Torino", "L378 Trento",
"L424 Trieste", "L736 Venezia"
];
window.onload = getComune();

function getComune() {
    let com = document.getElementById("comune");
    for(let i = 0; i < comuni.length; i++) {
        //la seguente espressione è stata trovata sul corso di javascript.info
        let node = document.createElement("option");
        node.textContent = comuni[i].substring(comuni[i].indexOf(" "));
        node.value = comuni[i];
        com.appendChild(node);
    }
}

function divideString(stringa) {
        stringa = (stringa + "").toUpperCase();
	for(let letter = 0; letter < stringa.length; letter++) {
		if(!isVocal(stringa.charAt(letter))) {
			cons += (stringa.charAt(letter));
		} else vocals += (stringa.charAt(letter));
	}
};
function getCognome(cognome) {
	divideString(cognome);
	let code = '';
	for(let letter = 0; letter < cons.length; letter++) {
		if(letter < 3)
			code += (cons.charAt(letter));
	}
	if(code.length < 3) {
		for(let letter = 0; letter < vocals.length; letter++) {
			if(code.length >= 3)
				break;
			else code += (vocals.charAt(letter));
		}
	}
	while(code.length < 3) 
		code += ("x");
	vocals = '';
	cons = '';
	return code.toUpperCase();
};

function getNome(nome) {
	divideString(nome);
	let code = '';
        console.log(cons.length);
        if(cons.length === 3) code += cons.substring(0, 3);
        else if(cons.length > 3) code += cons.charAt(0) + cons.charAt(2) + cons.charAt(3);
        else {
            for(let letter = 0; letter < cons.length; letter++) 
                code += (cons.charAt(letter));
            for(let letter = 0; letter < vocals.length; letter++) {
                    if(code.length >= 3)
                            break;
                    else code += (vocals.charAt(letter));
            }
            while(code.length < 3) 
                    code += ("x");
        }
	vocals = '';
	cons = '';
	return code.toUpperCase();
};

function getCodice() {
	let nome = document.getElementById("nome").value;
	let cognome = document.getElementById("cognome").value;
	let date = document.getElementById("date").value;
        let menu = document.getElementById("gender");
        let gender = menu.selectedIndex;//cercato su google questa espressione
        //let gender = menu.options[menu.selectedIndex].value;
	let selectedComune = document.getElementById("comune");
        let codiceComune = selectedComune.options[selectedComune.selectedIndex].value;
        let codiceFiscale = (getCognome(cognome) + getNome(nome) + 
                getDate(date, gender)).toUpperCase() + 
                codiceComune.substring(0, codiceComune.indexOf(" "));
        let controllo = getCodiceFinale(codiceFiscale);
        codiceFiscale += controllo;
	alert(codiceFiscale);
	/*let codice = getNome(nome) + getCognome(cognome) + getDate(date) +
			getComune(comune) + getValori();*/
}
function getDate(date, gender) {
	let code = '';
	let dateString = date + "";
        let values = dateString.split("-");
        code += values[0].substring(values[0].length - 2);
        code += month(values[1]);
        if(gender === 1) code += (parseInt(values[2]) + 40);
        else code += values[2];
	return code.toUpperCase();
}
function isVocal(stringa) {
	for(let i = 0; i < vocali.length; i++) {
		if(stringa === vocali[i]) return true;
	}
	return false;
}
function month(mese) {
	switch(mese) {
		case "01": return "A";
		case "02": return "B";
		case "03": return "C";
		case "04": return "D";
		case "05": return "E";
		case "06": return "H";
		case "07": return "L";
		case "08": return "M";
		case "09": return "P";
		case "10": return "R";
		case "11": return "S";
		case "12": return "T";
	}
}
function getCodiceFinale(code) {
    let controlCode = 0;
    for(let letter = 0; letter < code.length; letter++) {
        if((letter + 1) % 2 === 1) controlCode += oddChars(code.charAt(letter));
        else controlCode += evenChars(code.charAt(letter));
    }
    switch(controlCode % 26) {
        case 0: return "A";
        case 1: return "B";
        case 2: return "C";
        case 3: return "D";
        case 4: return "E";
        case 5: return "F";
        case 6: return "G";
        case 7: return "H";
        case 8: return "I";
        case 9: return "J";
        case 10: return "K";
        case 11: return "L";
        case 12: return "M";
        case 13: return "N";
        case 14: return "O";
        case 15: return "P";
        case 16: return "Q";
        case 17: return "R";
        case 18: return "S";
        case 19: return "T";
        case 20: return "U";
        case 21: return "V";
        case 22: return "W";
        case 23: return "X";
        case 24: return "Y";
        case 25: return "Z";
    }
}
function oddChars(code) {
    switch(code) {
        case "0": return 1;
        case "1": return 0;
        case "2": return 5;
        case "3": return 7;
        case "4": return 9;
        case "5": return 13;
        case "6": return 15;
        case "7": return 17;
        case "8": return 19;
        case "9": return 21;
        case "A": return 1;
        case "B": return 0;
        case "C": return 5;
        case "D": return 7;
        case "E": return 9;
        case "F": return 13;
        case "G": return 15;
        case "H": return 17;
        case "I": return 19;
        case "J": return 21;
        case "K": return 2;
        case "L": return 4;
        case "M": return 18;
        case "N": return 20;
        case "O": return 11;
        case "P": return 3;
        case "Q": return 6;
        case "R": return 8;
        case "S": return 12;
        case "T": return 14;
        case "U": return 16;
        case "V": return 10;
        case "W": return 22;
        case "X": return 25;
        case "Y": return 24;
        case "Z": return 23;
    }
}
function evenChars(code) {
    switch(code) {
        case "0": return 0;
        case "1": return 1;
        case "2": return 2;
        case "3": return 3;
        case "4": return 4;
        case "5": return 5;
        case "6": return 6;
        case "7": return 7;
        case "8": return 8;
        case "9": return 9;
        case "A": return 0;
        case "B": return 1;
        case "C": return 2;
        case "D": return 3;
        case "E": return 4;
        case "F": return 5;
        case "G": return 6;
        case "H": return 7;
        case "I": return 8;
        case "J": return 9;
        case "K": return 10;
        case "L": return 11;
        case "M": return 12;
        case "N": return 13;
        case "O": return 14;
        case "P": return 15;
        case "Q": return 16;
        case "R": return 17;
        case "S": return 18;
        case "T": return 19;
        case "U": return 20;
        case "V": return 21;
        case "W": return 22;
        case "X": return 23;
        case "Y": return 24;
        case "Z": return 25;
    }
}


