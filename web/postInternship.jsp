<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post Internship</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Post Internship</h2>
        <form action="postInternship" method="post">
            <div class="input-group">
                <label for="title">Internship Title:</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="input-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" required></textarea>
            </div>
            <div class="input-group">
                <label for="company_id">Company ID:</label>
                <input type="number" id="company_id" name="company_id" required>
            </div>
            <div class="input-group">
                <label for="deadline">Deadline:</label>
                <input type="date" id="deadline" name="deadline" required>
            </div>
            <button type="submit" class="btn">Post Internship</button>
        </form>
    </div>
</body>
</html>
