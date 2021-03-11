document.querySelector("#postForm").addEventListener("submit", postData);
document.querySelector("#createButton").addEventListener("click", showCreate);

// run fnc
getAlbums();

function getAlbums() {

	axios.get("/albums")
	.then(res => {
		const albums = res.data;

		// loop through list of albums to get info on each
		albums.forEach(album => {
			
			// if no image is supplied, use default
			var imgSrc = "";
			var dfltImgSrc = "turntabled1.jpg";
			if (album.imgSrc == "") {
				imgSrc = dfltImgSrc;
			} else {
				imgSrc = album.imgSrc;
				noImgLbl = ""
			}

			// create an empty card		
			var html = document.createElement('div');
			html.setAttribute('class', 'card');
			// insert details of the html for a card
			html.innerHTML = '<div class="image"><img src="'+ imgSrc +'"></div><div class="extra content"><div class="header">'+ album.title +'</div><div class="meta">Released in '+ album.releaseYear +'</div><div class="description">'+ album.artist +'</div><span class="right floated"><button class="ui icon button edit" onclick="yeet('+ album.id +')"><i class="pencil alternate icon"></i></button><a class="ui icon button playBtn" href="'+ album.playSrc +'"target="_blank"><i class="play icon"></i></a></span></div>';

			// add card into the html
			var stack = document.querySelector("#stack");
			stack.appendChild(html);				
		});
	// catch and print any errors
	}).catch(err => console.error(err));
}

// show create form modal on btn click
function showCreate(){
	console.log("yum")
	$(".modalForm").modal('show');
}

// show edit form modal on button onclick 
function yeet(id){
	$(".editForm").modal('show');
	axios.get("/album/" + id)
		.then(res => {
			const chosenAlbum = res.data;
			console.log(chosenAlbum);
			document.getElementById("editTitle").value = chosenAlbum.title;
			document.getElementById("editArtist").value = chosenAlbum.artist;
			document.getElementById("editReleaseYear").value = chosenAlbum.releaseYear;
			document.getElementById("editImgSrc").value = chosenAlbum.imgSrc;
			document.getElementById("editPlaySrc").value = chosenAlbum.playSrc;
		});

		// Add an onlick that does an post/put to the endpoint
		// Refresh the page on success/close form

	// call post function if button clicked
	submitEditButton.addEventListener('click', () => postData(id));
	
	// call delete function if button clicked	
	deleteButton.addEventListener('click', () => deleteAlbum(id));	
}
	
function postData(id) {
	// grab values from form once submitted 
	// seperate into sep function that i can call with edit post button
	// reuse this for my update, but add id
	
	id = ""
	const data = {
		id: id,
		title: this.title.value,
		artist: this.artist.value,
		releaseYear: this.releaseYear.value,
		imgSrc: this.imgSrc.value,
		playSrc: this.playSrc.value
	};
	
	console.log(data)
	// post as json
	axios.post("/album", data, {
		headers: {
		"Content-Type": "application/json", 
		"Accept": "application/json"
		}
	// load up the content
	}).then(() => getAlbums())
		.catch(err => console.error(err));
	}

function deleteAlbum(id) {
	axios.delete("/album/" + id)
		.then(() => getAlbums())
		.catch(err => console.error(err));
};
	
	 