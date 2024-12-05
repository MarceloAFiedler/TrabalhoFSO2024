(function(){
    $('#tabelaclientes').on('click','.js-delete',function(){
        let botaoClicado = $(this)
        $('#btnsim').attr('data-id', botaoClicado.attr('data-id'))
        $('#modal').modal('show')
    })
    
    $(document).on('click', '#btnsim', function(){
        let botaoClicado = $(this)
        let id = botaoClicado.attr('data-id')
        console.log(id);
        $.ajax({
            url: `/clientes/delete/${id}`,
            method: 'GET',
            success: function(){
                window.location.href = '/clientes'
            }
        })

    })

})()


