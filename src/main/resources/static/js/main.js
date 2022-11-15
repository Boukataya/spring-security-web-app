// $("table .edit").click(function () {
//
//     $(".modal-title").text('Edit Member Information');
//     var id = $(this).parent().find('#memberId').val();
//     console.log(id);
//     $.ajax({
//         type: 'GET',
//         url: '/api/member/' + id,
//         success: function (response) {
//             console.log(response);
//             $("input[name=firstname]").val(response.firstname);
//             $("input[name=lastname]").val(response.lastname);
//             $("input[name=email]").val(response.email);
//             $("input[name=phone]").val(response.phone);
//             $("input[name=address]").val(response.address);
//             $("input[name=country]").val(response.country);
//             $("input[name=city]").val(response.city);
//             if (response.active)
//                 $("#active").prop("checked", true)
//             else
//                 $("#inactive").prop("checked", true)
//
//         }
//     });
// });
//
// $(".add-new").click(function () {
//     $(".modal-title").text('Add New Member');
//     $("input[name=firstname]").val('');
//     $("input[name=lastname]").val('');
//     $("input[name=email]").val('');
//     $("input[name=phone]").val('');
//     $("input[name=address]").val('');
//     $("input[name=country]").val('');
//     $("input[name=city]").val('');
//     $("input[name=member_status]").prop('checked', false);
//
// });
//
// $("table .delete").click(function () {
//     var id = $(this).parent().find('#memberId').val();
//     Swal.fire({
//       title: 'Are you sure?',
//       text: "You won't be able to revert this!",
//       icon: 'warning',
//       showCancelButton: true,
//       confirmButtonColor: '#3085d6',
//       cancelButtonColor: '#d33',
//       confirmButtonText: 'Yes, delete it!'
//     }).then((result) => {
//       if (result.isConfirmed) {
//       window.location.replace("/members/delete/" + id);
//         Swal.fire(
//           'Deleted!',
//           'Your file has been deleted.',
//           'success'
//         )
//       }
//     })
// });