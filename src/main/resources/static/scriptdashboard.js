(function(){
   
    $('.tabela_listar').on('click', '.js-delete', function(){
        let botaoClicado = $(this);
        let tabela = botaoClicado.closest('table').attr('id');
        
        let tipo = tabela === 'tabeladashboard_projetos' ? 'projetos' : 'metas';
        
        $('#btnsim')
            .attr('data-id', botaoClicado.attr('data-id'))
            .attr('data-tipo', tipo);
        
        $('#modal').modal('show');
    });

    $(document).on('click', '#btnsim', function(){
        let botaoClicado = $(this);
        let id = botaoClicado.attr('data-id');
        let tipo = botaoClicado.attr('data-tipo');

        console.log(`Excluindo ${tipo} com ID: ${id}`);
        $.ajax({
            url: `/${tipo}/delete/${id}`,
            method: 'GET',
            success: function(){
                window.location.href = '/dashboard';
            },
            error: function(){
                alert('Erro ao excluir item.');
            }
        });
    });
})();
