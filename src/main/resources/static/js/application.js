
$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});

	$('.date').mask('11/11/1111');
	$('.anomes').mask('0000-00');
	$('.time').mask('00:00:00');
	$('.date_time').mask('00/00/0000 00:00:00');
	$('.cep').mask('00000-000');
	$('.mixed').mask('AAA 000-S0S');
	$('.cpf').mask('000.000.000-00', {reverse: true});
	$('.money').mask('000.000.000.000.000,00', {reverse: true});
	$('.number').mask('000.000', {reverse: true});
	$('.boleto').mask('0000', {reverse: true});

	var maskBehavior = function (val) {
		 return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		},
		options = {onKeyPress: function(val, e, field, options) {
		 field.mask(maskBehavior.apply({}, arguments), options);
		 }
		};

	$('.phone').mask(maskBehavior, options);

	$('.js-atualizar-status').on('click', function(event) {
		event.preventDefault();

		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');

		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
		});


		response.done(function(e) {
			var codigoTitulo = botaoReceber.data('codigo');
			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">' + e + '</span>');
			botaoReceber.hide();
		});

		response.fail(function(e) {
			console.log(e);
			alert('Erro recebendo cobrança');
		});

	});
});
