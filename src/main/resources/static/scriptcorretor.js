(function(){
    $('#tabelacorretores').on('click','.js-delete',function(){
        let botaoClicado = $(this)
        $('#btnsim').attr('data-id', botaoClicado.attr('data-id'))

        $('#modalcorretor').modal('show');
    });

    $(document).on('click','#btnsim', function(){
        let botaoClicado = $(this)
        let id = botaoClicado.attr('data-id')
        $.ajax({
            url: '/corretores/delete/' + id,
            method: 'GET',
            success: function(){
                window.location.href = '/corretores'
            }
        })
    })

})();