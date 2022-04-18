const Templates = {};

$(document).ready( e => {
	const $htmls = $('script[type="text/x-handlebars-template"]');
	console.log("$htmls>>", $htmls)
	$htmls.each( (idx, h) => {
		let tid = $(h).attr('id');
		console.debug("tid>>", tid)
		Templates[tid] = Handlebars.compile($(h).html());
	});
});
	  
let renderHbs = function(tid, jsonData, tag) {
	tag = tag || 'div';
    let $tmpl = $('#' + tid); // "#" + "tmpl2"
    let html = Templates[tid](jsonData);
    let cssClass = $tmpl.attr('class') || "";
    $tmpl.replaceWith(`<${tag} id="${tid}" class="${cssClass}">` + html + `</${tag}>`)
};

Handlebars.registerHelper('eq', function(a, b, options) {
	return a == b;
});

moment.locale('ko');
Handlebars.registerHelper('fromNow', function(dt, options) {
	return moment(dt).fromNow();
});

Handlebars.registerHelper('fullTime', function(dt, options) {
	return moment(dt).format('llll');
});

Handlebars.registerHelper('fitTime', function(dt, options) {
	let m = moment(dt),
		now = moment();
	
	if (now.diff(m, 'day') < 24 && now.format('D') === m.format('D'))
		return m.format('HH:mm:ss');
	else
		return m.format('MM/DD HH:mm');
		
});

Handlebars.registerHelper('transHtml', function(str) {
	if (!str) return str;
	return str.replace(/[\r\n]/g, '<br>');
});

Handlebars.registerHelper('eqp', function(a, b, c, options) {
	return a == b ? c : '';
});

