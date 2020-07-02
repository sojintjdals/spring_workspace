const color1 = "color1";
const color2 = "color2";
const color3 = "color3";
const color4 = "color4";
let contents = document.querySelector("#contents");
let selectColor = document.querySelector("#selectColor");
console.log(contents.classList);
selectColor.addEventListener("change", function() {
	if (selectColor.value == "black") {
		if (contents.classList.contains(color1))
			contents.classList.remove(color1);
		else if (contents.classList.contains(color2))
			contents.classList.remove(color2);
		else if (contents.classList.contains(color3))
			contents.classList.remove(color3);
		else if (contents.classList.contains(color4))
			contents.classList.remove(color4);
		contents.classList.add(color1);
	} else if (selectColor.value == "blue") {
		if (contents.classList.contains(color1))
			contents.classList.remove(color1);
		else if (contents.classList.contains(color2))
			contents.classList.remove(color2);
		else if (contents.classList.contains(color3))
			contents.classList.remove(color3);
		else if (contents.classList.contains(color4))
			contents.classList.remove(color4);
		contents.classList.add(color2);
	} else if (selectColor.value == "green") {
		if (contents.classList.contains(color1))
			contents.classList.remove(color1);
		else if (contents.classList.contains(color2))
			contents.classList.remove(color2);
		else if (contents.classList.contains(color3))
			contents.classList.remove(color3);
		else if (contents.classList.contains(color4))
			contents.classList.remove(color4);
		contents.classList.add(color3);
	} else if (selectColor.value == "red") {
		if (contents.classList.contains(color1))
			contents.classList.remove(color1);
		else if (contents.classList.contains(color2))
			contents.classList.remove(color2);
		else if (contents.classList.contains(color3))
			contents.classList.remove(color3);
		else if (contents.classList.contains(color4))
			contents.classList.remove(color4);
		contents.classList.add(color4);
	}
});
