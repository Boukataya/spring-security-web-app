$("table .edit").click(function() {
  var id = $(this).parent().find('#memberId').val();
  console.log(id);
  $.ajax({
    type: 'GET',
    url: '/api/member/' + id,
    success: function(response){
    console.log(response);
    $("input[name=firstname]").val(response.firstname);
    $("input[name=lastname]").val(response.lastname);
    $("input[name=email]").val(response.email);
    $("input[name=phone]").val(response.phone);
    $("input[name=address]").val(response.address);
    $("input[name=country]").val(response.country);
    $("input[name=city]").val(response.city);
    if(response.active)
    $("#active").prop("checked", true)
    else
    $("#inactive").prop("checked", true)

    }
  });
});
