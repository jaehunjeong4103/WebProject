let start = document.getElementById('s_d');
let end = document.getElementById('e_d');
let cal_button = document.querySelectorAll('.cal_button');
let weekend_count = document.getElementById('weekend_count');
let weekday_count = document.getElementById('weekday_count');
let check_in = document.getElementById('check_in');
let check_out = document.getElementById('check_out');
	
cal_button.forEach(function(button) {
	button.addEventListener('click', select_cal);
});
				
function select_cal(){
	let year = this.dataset.s_year;
	let month = this.dataset.s_month.padStart(2, '0');
	let day = this.dataset.s_day.padStart(2, '0');
		
	let select_date = new Date(year, month -1, day);
	let current_date = new Date();
	
	if (select_date < current_date){
		return;
	}					
										
	if (start.value == null || start.value == "") {
		start.value = year+"-"+month+"-"+day;
		check_in.value = year+"-"+month+"-"+day;
	} else {
		
		let start_date = new Date(start.value);
		
		if (select_date < start_date) {
			return;
		} else{
			end.value = year+"-"+month+"-"+day;
			check_out.value = year+"-"+month+"-"+day;
		}		
	}						
					
	let start_date = new Date(start.value);
	let end_date = new Date(end.value);
	let time_different = Math.abs(end_date.getTime() - start_date.getTime());
	let different_days = Math.ceil(time_different / (1000 * 3600 * 24));
					
	let weekdays = 0;
	let weekends = 0;
					
	for (let i = 0; i <= different_days; i++) {
		let current_date = new Date(start_date);
			current_date.setDate(start_date.getDate() + i);
		let current_day_of_week = current_date.getDay();
			if (current_day_of_week >= 1 && current_day_of_week <= 5) {
				weekdays++;
			}else {
				weekends++;
			}
			
			console.log("Number of weekdays:", weekdays);
			console.log("Number of weekends:", weekends);
			
	}
			weekend_count.value = weekends;
			weekday_count.value = weekdays;		
}