
function SelectPeriodo(){
// ON selection of category this function will work

removeAllOptions(document.drop_list.periodo);
addOption(document.drop_list.periodo, "", "periodo", "");

if(document.drop_list.tipo.value == 'Pasantias'){
addOption(document.drop_list.periodo,"Mango", "Mango");
addOption(document.drop_list.periodo,"Banana", "Banana");
addOption(document.drop_list.periodo,"Orange", "Orange");
}
if(document.drop_list.tipo.value == 'ProyectosDeGrado'){
addOption(document.drop_list.periodo,"Cricket", "Cricket");
addOption(document.drop_list.periodo,"Football", "Football");
addOption(document.drop_list.periodo,"Polo", "Polo", "");
}

}
//////////////////

function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		//selectbox.options.remove(i);
		selectbox.remove(i);
	}
}


function addOption(selectbox, value, text )
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;

	selectbox.options.add(optn);
}



